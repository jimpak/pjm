package com.pjm.projectsns.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUploadFile is a Querydsl query type for UploadFile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUploadFile extends EntityPathBase<UploadFile> {

    private static final long serialVersionUID = 626571081L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUploadFile uploadFile = new QUploadFile("uploadFile");

    public final QAuditingFields _super = new QAuditingFields(this);

    //inherited
    public final DateTimePath<java.sql.Timestamp> createAt = _super.createAt;

    //inherited
    public final DateTimePath<java.sql.Timestamp> deletedAt = _super.deletedAt;

    public final StringPath filename = createString("filename");

    public final NumberPath<Long> fno = createNumber("fno", Long.class);

    public final BooleanPath image = createBoolean("image");

    public final QPost post;

    //inherited
    public final DateTimePath<java.sql.Timestamp> updatedAt = _super.updatedAt;

    public final StringPath uuid = createString("uuid");

    public QUploadFile(String variable) {
        this(UploadFile.class, forVariable(variable), INITS);
    }

    public QUploadFile(Path<? extends UploadFile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUploadFile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUploadFile(PathMetadata metadata, PathInits inits) {
        this(UploadFile.class, metadata, inits);
    }

    public QUploadFile(Class<? extends UploadFile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.post = inits.isInitialized("post") ? new QPost(forProperty("post"), inits.get("post")) : null;
    }

}

