// const Food = ({ food }) => {
//     const { id, name, rating, image } = food;
//     return (
//         <div>
//             번호: {id} <br />
//             이름: {name} <br />
//             평점: {rating} <br />
//             사진: <img src={image} style={{ width: '100px', height: '100px' }} />
//             <br />
//             <br />
//         </div>
//     );
// };

const Food = ({ food }) => {
    return (
        <div>
            번호 : {food.id} <br />
            이름 : {food.name} <br />
            평점 : {food.rating} <br />
            사진 : <img src={food.image} style={{ width: '100px', height: '100px' }} />
            <br />
        </div>
    );
};

export default Food;
