package com.example.newsimprove;

 class News {
     private String title;
     private String author;
     private String url;
     private String Imageurl;
     News(String title,String author,String url,String imageurl){
         this.title=title;
         this.author=author;
         this.url=url;
         this.Imageurl=imageurl;
     }

     public String getTitle() {
         return title;
     }

     public String getAuthor() {
         return author;
     }

     public String getUrl() {
         return url;
     }

     public String getImageurl() {
         return Imageurl;
     }

 }
