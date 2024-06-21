package com.nyist.dao;

import com.nyist.model.Myfile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MyfileMapper {
    /**
     * 上传文件
     * @param myfile
     * @return
     */
    public Integer uploadFiles(Myfile myfile);

    /**
     * 判断myfile表是否有数据
     * @return
     */
    public int findIdCounts();
    /**
     * 获取所有文件
     * @param id
     * @return
     */
    public List<Myfile> findAllFiles();

    /**
     * 获取单个文件
     * @param id
     * @return
     */
    public Myfile findFileById(Integer id);

    /**
     * 修改下载次数
     * @param id
     * @return
     */
    public Integer setDownLoadCounts(Integer id);

    /**
     * 回收文件
     * @param id
     * @return
     */
    public Integer setRecycles(Integer id);

    /**
     * 设置收藏文件
     * @param myfile
     * @return
     */
    public Integer setFavorites(Myfile myfile);

    /**
     * 关键字模糊查询
     * @param myfile
     * @return
     */
    public List<Myfile> findFilesByKey(Myfile myfile);

    /**
     * 获取所有图片
     * @param myfile
     * @return
     */
    public List<Myfile> findAllImages(Myfile myfile);

    /**
     * 获取所有收藏文件
     * @return
     */
    public List<Myfile> findAllFavorites(Myfile myfile);

    /**
     * 获取所有回收文件
     * @return
     */
    public List<Myfile> findAllRecycles();

    /**
     * 永久删除
     * @param id
     * @return
     */
    public Integer deleteAllFiles(Integer id);

    /**
     * 回收文件
     * @param id
     * @return
     */
    public Integer recoverAllFiles(Integer id);
}
