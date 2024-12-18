package com.yuand.smarteye.material.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuand.common.utils.PageUtils;
import com.yuand.smarteye.material.entity.MaterialTypeEntity;
import com.yuand.smarteye.material.vo.MaterialTypeRespVo;
import com.yuand.smarteye.material.vo.MaterialTypeShelfVo;
import com.yuand.smarteye.material.vo.ShelfRelationVo;

import java.util.List;
import java.util.Map;

/**
 * 库存种类
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-08-24 14:00:06
 */
public interface MaterialTypeService extends IService<MaterialTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    //查询某三级目录分类目录下的库存种类，0为全部
    PageUtils queryBaseMaterialTypePage(Map<String, Object> params, Long wlId, String type);

    //保存库存种类信息 及 对应的库存与货架关系
    void saveDetial(MaterialTypeShelfVo materialTypeShelfVo);

    //根据id查询，回显
    MaterialTypeRespVo getMaterialTypeInfo(Long materialTypeId);

    //库存种类信息 及 对应的库存与货架关系
    void updateDetial(MaterialTypeShelfVo materialTypeShelfVo);

    //获取货架关联的所有库存种类
    List<MaterialTypeEntity> getRelationMaterialType(Long shelfId);

    //获取货架未关联的所有库存种类
    PageUtils getNoRelationMaterialType(Map<String, Object> params, Long shelfId);

    //删除库存种类与货架的关联关系
    void deleteRelation(ShelfRelationVo[] vos);

}

