package e.sh.karamozibd.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import e.sh.karamozibd.entity.Comment;

@Dao
public interface daoComment {

    @Insert
    void insert(Comment... comments);

    @Update
    void update(Comment... comments);

    @Delete
    void delete(Comment... comments);

    @Query("Select * FROM comment WHERE postId==:postId")
    Comment[] loadPostComments(String postId);

    @Query("Select * FROM comment WHERE userId==:userId")
    Comment[] loadUserComments(String userId);
}