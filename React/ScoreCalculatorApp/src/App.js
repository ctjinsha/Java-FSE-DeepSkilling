import CalculateScore from "./Components/CalculateScore";

function App() {

    return (

        <div>

            <CalculateScore
                Name="John"
                School="ABC Higher Secondary School"
                Total={480}
                Goal={500}
            />

        </div>

    );

}

export default App;