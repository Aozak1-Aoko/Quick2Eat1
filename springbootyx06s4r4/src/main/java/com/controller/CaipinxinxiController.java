package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.CaipinxinxiEntity;
import com.entity.view.CaipinxinxiView;

import com.service.CaipinxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 菜品信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-06-01 22:37:20
 */
@RestController
@RequestMapping("/caipinxinxi")
public class CaipinxinxiController {
    @Autowired
    private CaipinxinxiService caipinxinxiService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CaipinxinxiEntity caipinxinxi,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shitangshangjia")) {
			caipinxinxi.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<CaipinxinxiEntity> ew = new EntityWrapper<CaipinxinxiEntity>();
        if(pricestart!=null) ew.ge("price", pricestart);
        if(priceend!=null) ew.le("price", priceend);


        //查询结果
		PageUtils page = caipinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caipinxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CaipinxinxiEntity caipinxinxi, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<CaipinxinxiEntity> ew = new EntityWrapper<CaipinxinxiEntity>();
        if(pricestart!=null) ew.ge("price", pricestart);
        if(priceend!=null) ew.le("price", priceend);

        //查询结果
		PageUtils page = caipinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caipinxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CaipinxinxiEntity caipinxinxi){
       	EntityWrapper<CaipinxinxiEntity> ew = new EntityWrapper<CaipinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( caipinxinxi, "caipinxinxi")); 
        return R.ok().put("data", caipinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CaipinxinxiEntity caipinxinxi){
        EntityWrapper< CaipinxinxiEntity> ew = new EntityWrapper< CaipinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( caipinxinxi, "caipinxinxi")); 
		CaipinxinxiView caipinxinxiView =  caipinxinxiService.selectView(ew);
		return R.ok("查询菜品信息成功").put("data", caipinxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CaipinxinxiEntity caipinxinxi = caipinxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(caipinxinxi,deSens);
        return R.ok().put("data", caipinxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CaipinxinxiEntity caipinxinxi = caipinxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(caipinxinxi,deSens);
        return R.ok().put("data", caipinxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CaipinxinxiEntity caipinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caipinxinxi);
        caipinxinxiService.insert(caipinxinxi);
        return R.ok().put("data",caipinxinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CaipinxinxiEntity caipinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caipinxinxi);
        caipinxinxiService.insert(caipinxinxi);
        return R.ok().put("data",caipinxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CaipinxinxiEntity caipinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caipinxinxi);
        //全部更新
        caipinxinxiService.updateById(caipinxinxi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        caipinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
