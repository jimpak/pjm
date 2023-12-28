package com.example.sb02.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = 477966773L;

    public static final QBoard board = new QBoard("board");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Long> bno = createNumber("bno", Long.class);

    public final ListPath<Comment, QComment> comments = this.<Comment, QComment>createList("comments", Comment.class, QComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath title = createString("title");

    public final NumberPath<Integer> visitcount = createNumber("visitcount", Integer.class);

    public final StringPath writer = createString("writer");

    public QBoard(String variable) {
        super(Board.class, forVariable(variable));
    }

    public QBoard(Path<? extends Board> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoard(PathMetadata metadata) {
        super(Board.class, metadata);
    }

}

