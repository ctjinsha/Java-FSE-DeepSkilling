import "../Stylesheets/mystyle.css";

function CalculateScore(props) {

    const average = (props.Total / 5).toFixed(2);

    return (

        <div className="container">

            <h1>Student Management Portal</h1>

            <h2>Student Details</h2>

            <p><b>Name:</b> {props.Name}</p>

            <p><b>School:</b> {props.School}</p>

            <p><b>Total Marks:</b> {props.Total}</p>

            <p><b>Goal:</b> {props.Goal}</p>

            <p><b>Average Score:</b> {average}</p>

        </div>

    );

}

export default CalculateScore;