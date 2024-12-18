package com.yuand.smarteye.material.controller;

import com.yuand.common.utils.PageUtils;
import com.yuand.common.utils.R;
import com.yuand.smarteye.material.entity.MbilldetailEntity;
import com.yuand.smarteye.material.service.MbilldetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 物料申请单详情
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-09-01 19:48:53
 */
@RestController
@RequestMapping("material/mbilldetail")
public class MbilldetailController {
    @Autowired
    private MbilldetailService mbilldetailService;

    /**
     * 物料申请确认送达
     */
    @RequestMapping("{mbilldetailId}/received")
    public R received(@PathVariable("mbilldetailId") Long mbilldetailId) {
        mbilldetailService.received(mbilldetailId);

        return R.ok();
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = mbilldetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 查询mbillid下的所有申请详情
     */
    @RequestMapping("{mbillId}/info")
    public R millinfo(@PathVariable("mbillId") Long mbillId) {
        List<MbilldetailEntity> res = mbilldetailService.getByMbillId(mbillId);

        return R.ok().put("data", res);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{mbilldetailId}")
    public R info(@PathVariable("mbilldetailId") Long mbilldetailId) {
        MbilldetailEntity mbilldetail = mbilldetailService.getById(mbilldetailId);

        return R.ok().put("mbilldetail", mbilldetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MbilldetailEntity mbilldetail) {
        mbilldetailService.save(mbilldetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MbilldetailEntity mbilldetail) {
        mbilldetailService.updateById(mbilldetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] mbilldetailIds) {
        mbilldetailService.removeByIds(Arrays.asList(mbilldetailIds));

        return R.ok();
    }

}
