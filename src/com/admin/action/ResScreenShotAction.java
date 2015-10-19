package com.admin.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.axis.utils.StringUtils;
import org.apache.log4j.Logger;

import com.admin.constant.SysParamCode;
import com.admin.model.SysParam;
import com.admin.model.WebResourceScreenshot;
import com.core.app.action.base.BaseAction;
import com.core.app.action.base.ResponseData;
import com.core.app.action.base.ResponseUtils;
import com.core.jdbc.util.PageBean;

/**
 * 网站资源分組展示类
 * 
 * @author tanson lam
 * 
 */
public class ResScreenShotAction extends BaseAction {

	private static Logger logger = Logger.getLogger(MainAction.class);
	private static final String LIST_PAGE = "/admin/res/screenshotlist.html";
	private static final String EDIT_FORM = "/admin/res/screenshotedit.html";

	/**
	 * 查詢列表
	 */
	public void show() {
		try {
			Map<String, Object> dataModel = new HashMap<String, Object>();
			String pageStr = request.getParameter("page");
			String pageSizeStr = request.getParameter("pageSize");
			Integer page = StringUtils.isEmpty(pageStr) ? null : Integer
					.valueOf(pageStr);
			Integer pageSize = StringUtils.isEmpty(pageSizeStr)
					? null
					: Integer.valueOf(pageSizeStr);
			String condition = bulidConditionSql();
			PageBean pageBean = baseModelService.pageQuery(condition,
					bulidOrderBySql(), pageSize, page,
					WebResourceScreenshot.class);
			pageBean.setPageUrl(getPaginationUrl("/Admin-ResScreenShot-show.action"));
			dataModel.put("pageBean", pageBean);
			render(LIST_PAGE, dataModel);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 显示编辑表单
	 */
	public void showEditForm() {
		Map<String, Object> dataModel = new HashMap<String, Object>();
		try {
			String id = request.getParameter("id");
			if (!StringUtils.isEmpty(id)) {
				WebResourceScreenshot webResourceScreenshot = findOne(
						Integer.valueOf(id), WebResourceScreenshot.class);
				dataModel.put("bean", webResourceScreenshot);
			}
			List<SysParam> iseffCode = sysParamService
					.getSysParam(SysParamCode.ISEFF);
			dataModel.put("iseffCode", iseffCode);
			render(EDIT_FORM, dataModel);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 保存
	 */
	public void save() {
		ResponseData responseData = null;
		try {
			String id = request.getParameter("id");
			WebResourceScreenshot webResourceScreenshot = new WebResourceScreenshot();
			this.buildPageData(webResourceScreenshot);

			if (!StringUtils.isEmpty(id)) {
				webResourceScreenshot.setId(Integer.valueOf(id));
				baseModelService.update(webResourceScreenshot);
			} else {
				baseModelService.save(webResourceScreenshot);
			}
			responseData = ResponseUtils.success("保存成功！");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			responseData = ResponseUtils.fail("保存失败！");
		}
		this.outResult(responseData);
	}

	/**
	 * 删除
	 */
	public void delete() {
		ResponseData responseData = null;
		try {
			String selectItems = request.getParameter("selectItems");
			if (selectItems.isEmpty()) {
				responseData = ResponseUtils.fail("没有选中的数据！");
				this.outResult(responseData);
				return;
			}
			String[] selectArr = selectItems.split(",");
			for (String id : selectArr) {
				WebResourceScreenshot webResourceScreenshot = baseModelService
						.findOne(Integer.valueOf(id),
								WebResourceScreenshot.class);
				if (webResourceScreenshot != null)
					baseModelService.delete(webResourceScreenshot);
			}
			responseData = ResponseUtils.success("删除成功！");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			responseData = ResponseUtils.fail("删除失败！");
		}
		this.outResult(responseData);
	}
}