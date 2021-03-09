package cn.resico.test.service.impl;

import cn.resico.test.converter.InterfaceConverter;
import cn.resico.test.dto.InterfaceDTO;
import cn.resico.test.dto.InterfaceInstanceDTO;
import cn.resico.test.entity.InterfaceHistory;
import cn.resico.test.entity.InterfaceInstance;
import cn.resico.test.mapper.InterfaceHistoryMapper;
import cn.resico.test.mapper.InterfaceInstanceMapper;
import cn.resico.test.mapper.InterfaceMapper;
import cn.resico.test.entity.Interface;
import cn.resico.test.service.InterfaceService;
import cn.resico.test.vo.interfcace.InterfaceQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("interfaceServiceImpl")
public class InterfaceServiceImpl implements InterfaceService {

    //service层 调用dao层
    @Autowired
    private InterfaceMapper interfaceMapper;
    @Autowired
    private InterfaceInstanceMapper interfaceInstanceMapper;
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
    public List<InterfaceInstanceDTO> queryInterfaceInstanceById(Integer id) {
        return interfaceMapper.selectInstance(id);
    }

    @Override
    public List<Interface> queryInterfaceByIds(List<Integer> ids) {
        return interfaceMapper.selectBatchIds(ids);
    }

    @Override
    public List<InterfaceDTO> query(InterfaceQuery query) {
        return interfaceMapper.selectList(query);
    }

    @Override
    public int addInstance(InterfaceInstance i) {
        return interfaceInstanceMapper.insert(i);
    }

    @Override
    public int updateInstance(InterfaceInstance i) {
        return interfaceInstanceMapper.updateById(i);
    }

    @Override
    public int deleteInstance(Integer id) {
        return interfaceInstanceMapper.deleteById(id);
    }

    @Override
    public int deleteInstancesByIds(List<Integer> ids) {
        return interfaceInstanceMapper.deleteBatchIds(ids);
    }





}
