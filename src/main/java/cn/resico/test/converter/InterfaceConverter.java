package cn.resico.test.converter;

import cn.resico.test.entity.Interface;
import cn.resico.test.entity.InterfaceHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * entity转化
 */
@Mapper
public interface InterfaceConverter {
    InterfaceConverter INSTANCE = Mappers.getMapper(InterfaceConverter.class);

    InterfaceHistory interfaceToHistory(Interface i);

}
