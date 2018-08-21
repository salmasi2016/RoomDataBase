package e.sh.karamozibd.util;

import e.sh.karamozibd.database.AppDataBase;
import e.sh.karamozibd.entity.Comment;
import e.sh.karamozibd.entity.Post;
import e.sh.karamozibd.entity.User;

public class DataGenerator {
    private static DataGenerator dataGenerator;
    private static AppDataBase dataBase;

    public static DataGenerator with(AppDataBase appDataBase){
        if (dataBase==null){
            dataBase=appDataBase;
        }
        if (dataGenerator==null){
            dataGenerator=new DataGenerator();
        }
        return dataGenerator;
    }

    public void generateUser(){
        if (dataBase==null){
            return;
        }
        User[] users=new User[4];
        users[0]=userInstance(111,"sina","almasi","1110");
        users[1]=userInstance(112,"hediye","moloudi","1120");
        users[2]=userInstance(113,"mohammad","sianaki","1130");
        users[3]=userInstance(114,"negar","almasi","1140");
        dataBase.daoUser().insert(users);
    }

    private User userInstance(int id,String name,String family,String avatar){
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setFamily(family);
        user.setAvatar(avatar);
        return user;
    }

    public void generatePost(){
        if (dataBase==null){
            return;
        }
        Post[] posts=new Post[3];
        posts[0]=postInstance(211,"post1","football","2110",112);
        posts[1]=postInstance(212,"post2","football","2120",111);
        posts[2]=postInstance(213,"post3","shena","2130",111);
        dataBase.daoPost().insert(posts);
    }

    private Post postInstance(int id,String title,String discreption,String avatar,int userId){
        Post post=new Post();
        post.setId(id);
        post.setTitle(title);
        post.setDiscreption(discreption);
        post.setAvatar(avatar);
        post.setUserId(userId);
        return post;
    }

    public void generateComment(){
        if (dataBase==null){
            return;
        }
        Comment[] comments=new Comment[5];
        comments[0]=commentInstance(311,"sina","ok1",111,211);
        comments[1]=commentInstance(312,"hediye","ok2",112,211);
        comments[2]=commentInstance(313,"sina","ok3",111,212);
        comments[3]=commentInstance(314,"negar","ok4",114,211);
        comments[4]=commentInstance(315,"hediye","ok5",112,213);
        dataBase.daoComment().insert(comments);
    }

    private Comment commentInstance(int id,String username,String text,int userId,int postId){
        Comment comment=new Comment();
        comment.setId(id);
        comment.setUsername(username);
        comment.setText(text);
        comment.setUserId(userId);
        comment.setPostId(postId);
        return comment;
    }
}