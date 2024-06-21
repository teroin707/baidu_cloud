package com.nyist.service.Impl;

import com.nyist.dao.MyfileMapper;
import com.nyist.model.Myfile;
import com.nyist.service.MyfileService;
import com.nyist.utils.FileTypeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MyfileServiceImpl implements MyfileService {

    @Autowired
    private MyfileMapper myfileMapper;
    @Autowired
    private FileTypeUtils fileTypeUtils;

    /**
     * 上传文件
     * @param myfile
     * @return
     */
    @Override
    public Integer uploadFiles(Myfile myfile) throws ParseException {
        //获取系统当前时间
        //生成日期对象
        Date current_date = new Date();
        //设置日期格式化样式为：yyyy-MM-dd
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String uploadtime = simpleDateFormat.format(current_date);
        //设置上传时间和修改时间
        myfile.setUploadtime(simpleDateFormat.parse(uploadtime));
        myfile.setChangetime(simpleDateFormat.parse(uploadtime));
        //设置是否为图片
        boolean isima = myfile.getType().startsWith("image");
        if (isima){
            myfile.setIsimg(1);
        }else{
            myfile.setIsimg(0);
        }
        return this.myfileMapper.uploadFiles(myfile);
    }


    /**
     * 判断myfile表是否有数据
     * @return
     */
    @Override
    public int findIdCounts() {
        return this.myfileMapper.findIdCounts();
    }

    /**
     * 获取所有文件
     * @param id
     * @return
     */
    @Override
    public List<Myfile> findAllFiles() {
        List<Myfile> allFiles = this.myfileMapper.findAllFiles();
        return this.fileTypeUtils.IconFilesList(allFiles);
    }

    /**
     * 获取单个文件
     * @param id
     * @return
     */
    @Override
    public Myfile findFileById(Integer id) {
        return this.myfileMapper.findFileById(id);
    }

    /**
     * 修改下载次数
     * @param id
     * @return
     */
    @Override
    public Integer setDownLoadCounts(Integer id) {
        return this.myfileMapper.setDownLoadCounts(id);
    }

    /**
     * 收藏文件
     * @param myfile
     * @return
     */
    @Override
    public Integer setFavorites(Myfile myfile) {
        return this.myfileMapper.setFavorites(myfile);
    }

    /**
     * 回收文件
     * @param id
     * @return
     */
    @Override
    public Integer setRecycles(Integer id) {
        return this.myfileMapper.setRecycles(id);
    }

    /**
     * 关键字模糊查询
     * @param myfile
     * @return
     */
    @Override
    public List<Myfile> findFilesByKey(Myfile myfile) {
        List<Myfile> allFiles = this.myfileMapper.findFilesByKey(myfile);
        return this.fileTypeUtils.IconFilesList(allFiles);
    }

    /**
     * 获取所有图片
     * @param myfile
     * @return
     */
    @Override
    public List<Myfile> findAllImages(Myfile myfile) {
        return this.myfileMapper.findAllImages(myfile);
    }

    /**
     * 获得所有收藏文件
     * @param myfile
     * @return
     */
    @Override
    public List<Myfile> findAllFavorites(Myfile myfile) {
        List<Myfile> allFavorites = this.myfileMapper.findAllFavorites(myfile);
        return this.fileTypeUtils.IconFilesList(allFavorites);
    }

    /**
     * 获取所有回收文件
     * @param
     * @return
     */
    @Override
    public List<Myfile> findAllRecycles() {
        List<Myfile> allRecycles = this.myfileMapper.findAllRecycles();
        return this.fileTypeUtils.IconFilesList(allRecycles);
    }

    /**
     * 永久删除
     * @param id
     * @return
     */
    @Override
    public Integer deleteAllFiles(Integer id) {
        return this.myfileMapper.deleteAllFiles(id);
    }

    /**
     * 回收文件
     * @param id
     * @return
     */
    @Override
    public Integer recoverAllFiles(Integer id) {
        return this.myfileMapper.recoverAllFiles(id);
    }
}
