package cn.resico.test.service.impl;

import cn.resico.test.converter.InterfaceConverter;
import cn.resico.test.dto.InterfaceDTO;
import cn.resico.test.entity.InterfaceHistory;
import cn.resico.test.mapper.InterfaceHistoryMapper;
import cn.resico.test.mapper.InterfaceMapper;
import cn.resico.test.entity.Interface;
import cn.resico.test.service.InterfaceService;
import cn.resico.test.vo.interfcace.InterfaceQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("interfaceServiceImpl")
public class InterfaceServiceImpl implements InterfaceService {

    //service层 调用dao层
    @Autowired
    private InterfaceMapper interfaceMapper;
    @Autowired
    private InterfaceHistoryMapper interfaceHistoryMapper;


    @Override
    public int addInterface(Interface i) {
        return interfaceMapper.insert(i);
    }

    @Override
    public int updateInterface(Interface i) {
        Interface oldInterface = interfaceMapper.selectById(i.getId());

        InterfaceHistory history = InterfaceConverter.INSTANCE.interfaceToHistory(oldInterface);
        history.setInterfaceId(oldInterface.getId());
        interfaceHistoryMapper.insert(history);
        oldInterface.setName(i.getName());
        oldInterface.setRequestType(i.getRequestType());
        oldInterface.setProtocolType(i.getProtocolType());
        oldInterface.setData(i.getData());

        return interfaceMapper.updateById(oldInterface);
    }

    @Override
    public int deleteInterface(Integer id) {
        return interfaceMapper.deleteById(id);
    }

    @Override
    public int deleteInterfaceByIds(List<Integer> ids) {
        return interfaceMapper.deleteBatchIds(ids);
    }

    @Override
    public Interface queryInterfaceById(Integer id) {
        return interfaceMapper.selectById(id);
    }

    @Override
    public List<Interface> queryInterfaceByIds(List<Integer> ids) {
        return interfaceMapper.selectBatchIds(ids);
    }

    @Override
    public List<Interface> query(InterfaceQuery query) {
        QueryWrapper<Interface> wrapper = new QueryWrapper();
        if (null != query.getName() && "" != query.getName()) {
            wrapper.like("name", query.getName());
        }
        if (null != query.getGroupId()) {
            wrapper.like("group_id", query.getGroupId());
        }
        if (null != query.getRequestType() && "" != query.getRequestType())
            wrapper.like("request_type", query.getRequestType());
        return interfaceMapper.selectList(wrapper);
    }
}
