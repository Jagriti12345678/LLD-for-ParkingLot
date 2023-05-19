package models;

import java.util.Date;

public class BaseModel {
    private Long id;
    private Date createdAt;
    private Date LastModifiedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastModifiedAt() {
        return LastModifiedAt;
    }

    public void setLastModifiedAt(Date lastModifiedAt) {
        LastModifiedAt = lastModifiedAt;
    }
}
