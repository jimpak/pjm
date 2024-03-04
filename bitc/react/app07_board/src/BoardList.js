import BoardItem from './BoardItem';

const BoardList = ({ list, deleteBoard }) => {
    return (
        <div>
            <h3>Board List</h3>
            <ul>
                {list.map((item) => (
                    <BoardItem
                        key={item.num}
                        // board={item}
                        {...item}
                        deleteBoard={deleteBoard}
                    />
                    // <li key={item.num}>
                    //     <strong>Title:</strong> {item.title}, <strong>Content:</strong> {item.content}
                    // </li>
                ))}
            </ul>
        </div>
    );
};

export default BoardList;
