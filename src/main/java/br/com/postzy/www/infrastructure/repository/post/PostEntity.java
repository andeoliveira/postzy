package br.com.postzy.www.infrastructure.repository.post;

import br.com.postzy.www.domain.Post;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "post")
public class PostEntity {
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
    @Column
    String metaKeywords;
    @Column
    String metaDescription;
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

    public UUID getParentId() {
        return parentId;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
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

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public PostEntity(Post post) {
        this.content = post.content();
        this.title = post.title();
        this.slug = post.slug();
        this.metaKeywords = post.metaKeywords();
        this.metaDescription = post.metaDescription();
    }

}
