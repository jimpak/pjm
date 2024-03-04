import ItemBoard from './ItemBoard';

const ListBoard = ({ list, deleteBoard }) => {
    return (
        <div>
            <h3>ListBoard</h3>
            {list.map((item) => (
                <ItemBoard
                    key={item.num}
                    // board={item}
                    {...item}
                    deleteBoard={deleteBoard}
                />
            ))}
        </div>
    );
};

export default ListBoard;
