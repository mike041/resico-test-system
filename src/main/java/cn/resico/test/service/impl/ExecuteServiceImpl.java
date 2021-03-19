package cn.resico.test.service.impl;

import cn.resico.test.dto.InterfaceInstanceDTO;
import cn.resico.test.service.ExecuteService;
import cn.resico.test.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExecuteServiceImpl implements ExecuteService {
    @Autowired
    InterfaceService interfaceService;

    @Override
    public void execute(List<Integer> list) {
        for (Integer testcaseId : list) {
            List<InterfaceInstanceDTO> interfaceInstanceDTOList = interfaceService.queryInterfaceInstanceById(testcaseId);
        }

    }
}
