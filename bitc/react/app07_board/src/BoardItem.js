const BoardItem = ({ num, title, content, deleteBoard }) => {
    return (
        <div>
            <h3>BoardItem</h3>
            {/* 번호 : {board.num}
            제목 : {board.title}
            내용 : {board.content} */}
            번호 : {num}
            <br />
            제목 : {title}
            <br />
            내용 : {content}
            <br />
            <button onClick={() => deleteBoard(num)}>삭제</button>
            <br />
            <br />
        </div>
    );
};

export default BoardItem;
