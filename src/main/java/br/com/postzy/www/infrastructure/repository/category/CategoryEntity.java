package br.com.postzy.www.infrastructure.repository.category;

import br.com.postzy.www.domain.Category;
import br.com.postzy.www.domain.Post;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @GeneratedValue
    private UUID id;
    @Column
    private UUID parentId;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String slug;
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @UpdateTimestamp
    @Column(name = "published_at")
    private Timestamp publishedAt;

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public UUID getParentId() {
        return parentId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
    public Timestamp getPublishedAt() {
        return publishedAt;
    }
    public String getSlug() {
        return slug;
    }
    public CategoryEntity(Category category) {
        this.content = category.content();
        this.title = category.title();
        this.slug = category.slug();
        this.parentId = category.parenteId();
    }

}
