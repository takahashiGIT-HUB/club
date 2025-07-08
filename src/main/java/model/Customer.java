package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Customer {
	private int id;
    private int userId;
    private String companyName;
    private String name;
    private Date birthday;
    private String lineId;
    private String keepBottle;
    private boolean likesGolf;
    private String memo;
    private Timestamp createdAt;
    
    public void setId(int id) {this.id= id;}
    public void setUserId(int userId) {this.userId= userId;}
    public void setCompanyName(String companyName) {this.companyName= companyName;}
    public void setName(String name) {this.name= name;}
    public void setBirthday(Date birthday) {this.birthday= birthday;}
    public void setLineId(String lineId) {this.lineId= lineId;}
    public void setKeepBottle(String keepBottle) {this.keepBottle= keepBottle;}
    public void setLikesGolf(boolean likesGolf) {this.likesGolf= likesGolf;}
    public void setMemo(String memo) {this.memo= memo;}
    public void setCreatedAt(Timestamp createdAt) {this.createdAt= createdAt;}
    
    public int getId() {return this.id;}
    public int getUserId() {return this.userId;}
    public String getCompanyName() {return this.companyName;}
    public String getName() {return this.name;}
    public Date getBirthday() {return this.birthday;}
    public String getLineId() {return this.lineId;}
    public String getKeepBottle() {return this.keepBottle;}
    public boolean isLikesGolf() { return this.likesGolf;}
    public String getMemo() {return this.memo;}
    public Timestamp createdAt() {return this.createdAt;}
    
    
    
    
}
