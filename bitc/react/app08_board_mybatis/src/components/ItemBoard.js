const ItemBoard = ({ num, title, content, deleteBoard }) => {
    return (
        <div>
            <h3>ItemBoard</h3>
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

export default ItemBoard;
