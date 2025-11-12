package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussshitangshangjiaDao;
import com.entity.DiscussshitangshangjiaEntity;
import com.service.DiscussshitangshangjiaService;
import com.entity.vo.DiscussshitangshangjiaVO;
import com.entity.view.DiscussshitangshangjiaView;

@Service("discussshitangshangjiaService")
public class DiscussshitangshangjiaServiceImpl extends ServiceImpl<DiscussshitangshangjiaDao, DiscussshitangshangjiaEntity> implements DiscussshitangshangjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshitangshangjiaEntity> page = this.selectPage(
                new Query<DiscussshitangshangjiaEntity>(params).getPage(),
                new EntityWrapper<DiscussshitangshangjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshitangshangjiaEntity> wrapper) {
		  Page<DiscussshitangshangjiaView> page =new Query<DiscussshitangshangjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussshitangshangjiaVO> selectListVO(Wrapper<DiscussshitangshangjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussshitangshangjiaVO selectVO(Wrapper<DiscussshitangshangjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussshitangshangjiaView> selectListView(Wrapper<DiscussshitangshangjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshitangshangjiaView selectView(Wrapper<DiscussshitangshangjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
