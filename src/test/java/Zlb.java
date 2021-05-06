import cn.resico.test.common.utils.PropertiesUtils;
import cn.resico.test.common.utils.RandomUtils;
import cn.resico.test.entity.zlb.*;
import cn.resico.test.mapper.zlb.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

@ContextConfiguration(locations = {"classpath:applicationContent.xml"})
@Slf4j
public class Zlb extends BaseTest {

    @Autowired
    ZlbUsersMapper zlbUsersMapper;
    @Autowired
    ZlbCompanyMapper zlbCompanyMapper;
    @Autowired
    ZlbCompanyDetailMapper zlbCompanyDetailMapper;
    @Autowired
    ZlbCompanyBankAccountMapper zlbCompanyBankAccountMapper;
    @Autowired
    ZlbContractLogMapper zlbContractLogMapper;
    @Autowired
    ZlbCompanyTradeMapper zlbCompanyTradeMapper;
    @Autowired
    ZlbCompanyRelationMapper zlbCompanyRelationMapper;
    @Autowired
    ZlbCompanyCrmMapper zlbCompanyCrmMapper;
    @Autowired
    ZlbCompanySignMapper zlbCompanySignMapper;
    @Autowired
    ZlbTradeTaxItemMapper zlbTradeTaxItemMapper;
    @Autowired
    ZlbTaxItemMapper zlbTaxItemMapper;
    @Autowired
    ZlbTradeDeliveryMapper zlbTradeDeliveryMapper;
    long uid;

    String company = PropertiesUtils.getProperties("company");
    String phone = PropertiesUtils.getProperties("phone");
    long tradeId = PropertiesUtils.getLongProperties("tradeId");
    String companyCode = RandomUtils.randomHexString(16);
    String aesKey = RandomUtils.randomHexString(16);
    String offset = RandomUtils.randomHexString(16);
    String sign = RandomUtils.randomHexString(16);

    String invoiceCate;
    String invoiceContent;

    @Test
    public void createCompanyAccount() throws Exception {
        //创建账号和企业
        createCompany();
        //创建银行账号
        zlbCompanyBankAccountMapper.myInsert(RandomUtils.getLongNumber(), uid, RandomUtils.getLongNumber());
        //创建场景
        zlbCompanyTradeMapper.myInsert(RandomUtils.getLongNumber(), uid, tradeId);
        //创建交互成果
        insertRelation();
        //创建补充协议
        insertSupplement();
        //创建用工协议
        insertEmployment();
        //创建企业标识表
        zlbCompanySignMapper.myInsert(RandomUtils.getLongNumber(), uid, aesKey,
                offset,
                sign);
        //获取税目
        getTax();
        log.info(this.toString());
    }

    //添加补充协议
    void insertSupplement() {
        QueryWrapper wrapper = new QueryWrapper<ZlbContractLog>();
        wrapper.eq("contract_id", 14);
        wrapper.eq("status", 4);
        wrapper.eq("effective_status", 2);
        wrapper.orderByDesc("created_at");
        wrapper.eq("delete_flag", 0);

        ZlbContractLog zlbContractLog = (ZlbContractLog) zlbContractLogMapper.selectList(wrapper).get(0);

        String no = getNo(zlbContractLogMapper.getNo("supplement_service"));
        zlbContractLog.setId(RandomUtils.getLongNumber());
        zlbContractLog.setNo(no);
        zlbContractLog.setUid(uid);
        zlbContractLog.setFirstParty(company);
        zlbContractLogMapper.insert(zlbContractLog);
        log.info("添加补充协议成功");

    }

    String getNo(String old) {
        long num = Long.parseLong(old.substring(2));
        String no = String.valueOf(num + 1);
        String newNo = (old.length() - no.length() < 2) ?
                old.substring(0, 2) + no
                : old.substring(0, old.length() - no.length()) + no;
        return newNo;

    }


    //添加用工协议
    void insertEmployment() {

        QueryWrapper wrapper = new QueryWrapper<ZlbContractLog>();
        wrapper.eq("contract_id", 100);
        wrapper.eq("status", 4);
        wrapper.eq("effective_status", 2);
        wrapper.orderByDesc("created_at");
        wrapper.eq("delete_flag", 0);

        ZlbContractLog zlbContractLog = (ZlbContractLog) zlbContractLogMapper.selectList(wrapper).get(0);

        String no = getNo(zlbContractLogMapper.getNo("company_service"));

        zlbContractLog.setId(RandomUtils.getLongNumber());
        zlbContractLog.setNo(no);
        zlbContractLog.setUid(uid);
        zlbContractLog.setFirstParty(company);
        zlbContractLog.setCreatedName(company);
        zlbContractLogMapper.insert(zlbContractLog);
        log.info("添加用工协议成功");
    }

    void insertRelation() {
        QueryWrapper queryWrapper = new QueryWrapper<ZlbTradeDelivery>();
        queryWrapper.eq("trade_id", tradeId);
        List<ZlbTradeDelivery> list = zlbTradeDeliveryMapper.selectList(queryWrapper);

        for (ZlbTradeDelivery zlbTradeDelivery : list) {
            ZlbCompanyRelation zlbCompanyRelation = ZlbCompanyRelation.builder().id(RandomUtils.getLongNumber())
                    .uid(uid)
                    .tradeId(tradeId)
                    .parkId(1l)
                    .deliveryName(zlbTradeDelivery.getName())
                    .deleteFlag(false)
                    .createdAt(LocalDateTime.now())
                    .build();
            zlbCompanyRelationMapper.insert(zlbCompanyRelation);
        }

        log.info("添加交付成果成功");

    }


    void updateCrmRelation() {
        QueryWrapper wrapper = new QueryWrapper<ZlbCompanyCrm>();
        wrapper.eq("delete_flag", 0);
        wrapper.orderByDesc("created_at");


        ZlbCompanyCrm crm = (ZlbCompanyCrm) zlbCompanyCrmMapper.selectList(wrapper).get(0);
        crm.setId(RandomUtils.getLongNumber());
        crm.setUid(uid);
        zlbCompanyCrmMapper.insert(crm);
        log.info("添加crm关联成功");
    }


    void createCrm() {
        String body = "{\"province\":\"120000\",\"city\":\"120100\",\"area\":\"120101\",\"contacts\":[],\"customerId\":null,\"customerName\":\"%s\",\"phones\":[{\"phone\":\"%s\",\"source\":2}],\"type\":1,\"industryCode\":\"INS2020090300022\",\"district\":[\"120000\",\"120100\",\"120101\"],\"address\":\"测试\",\"source\":8,\"enterpriseType\":\"\",\"legalPerson\":\"\",\"website\":\"\",\"registeredDate\":\"\",\"registeredCapital\":\"\",\"contributedCapital\":\"\",\"staffSize\":\"\",\"remark\":\"\"}";
        body = String.format(body, company, phone);
        try {
            Unirest.post(host + "marketing/crm/cooperated/save").body(body).asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        log.info("添加crm合作客户成功");
    }

    void createCompany() throws Exception {
        //创建优税猫crm
        createCrm();

        if (!companyIsExist() || !userIsExist()) {
            throw new Exception("企业名称或电话已存在");
        }

        //创建用户
        zlbUsersMapper.myInsertUser(company, phone);
        setUid();

        //创建公司
        zlbCompanyMapper.myInsert(RandomUtils.getLongNumber(), uid, company, companyCode);
        zlbCompanyDetailMapper.myInsert(RandomUtils.getLongNumber(), uid, getCompanyId(), "周云腾");

        //创建crm与众乐邦关联表
        updateCrmRelation();
        log.info("添加认证企业成功");
    }


    private boolean companyIsExist() {
        QueryWrapper queryWrapper = new QueryWrapper<ZlbCompany>();
        queryWrapper.eq("company_name", company);
        return zlbCompanyMapper.selectList(queryWrapper).isEmpty();
    }

    private boolean userIsExist() {
        QueryWrapper queryWrapper = new QueryWrapper<ZlbUsers>();
        queryWrapper.eq("mobile", phone);
        return zlbUsersMapper.selectList(queryWrapper).isEmpty();
    }

    void setUid() {
        QueryWrapper wrapper = new QueryWrapper<ZlbUsers>();
        wrapper.eq("mobile", phone);
        uid = zlbUsersMapper.selectOne(wrapper).getId();
        log.info("uid->:" + uid);
    }

    long getCompanyId() {
        QueryWrapper wrapper = new QueryWrapper<ZlbCompany>();
        wrapper.eq("uid", uid);
        return zlbCompanyMapper.selectOne(wrapper).getId();
    }

    public void getTax() {
        QueryWrapper wrapper = new QueryWrapper<ZlbTradeTaxItem>();
        wrapper.eq("trade_id", tradeId);
        ZlbTradeTaxItem zlbTradeTaxItem = (ZlbTradeTaxItem) zlbTradeTaxItemMapper.selectList(wrapper).get(0);
        Long taxItemId = zlbTradeTaxItem.getTaxItemId();
        ZlbTaxItem zlbTaxItem = zlbTaxItemMapper.selectById(taxItemId);

        invoiceContent = zlbTaxItem.getTaxItemName();
        if (zlbTaxItem.getParentId() != 0) {
            invoiceCate = zlbTaxItemMapper.selectById(zlbTaxItem.getParentId()).getTaxItemName();
        }
    }

    @Override
    public String toString() {
        return
                "company='" + company + '\'' +
                        ", phone='" + phone + '\'' +
                        ", password='" + "123456" + '\'' +
                        ", aesKey='" + aesKey + '\'' +
                        ", offset='" + offset + '\'' +
                        ", sign='" + sign + '\'' +
                        ", tradeId='" + tradeId + '\'' +
                        ", invoiceCate='" + invoiceCate + '\'' +
                        ", invoiceContent='" + invoiceContent + '\'';
    }
}
