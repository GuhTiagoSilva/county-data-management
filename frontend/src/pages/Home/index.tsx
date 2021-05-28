import "./styles.scss";
import { ReactComponent as MainImage } from "../../core/assets/images/main-image.svg";
import ButtonIcon from "../../core/components/ButtonIcon";
import { Link } from "react-router-dom";

const Home = () => {
  return (
    <div className="home-container">
      <div className="row home-content card-base border-radius-20">
        <div className="col-6">
          <h1 className="text-title">
            Consulte os dados <br /> referentes aos municípios de SP
          </h1>
          <p className="text-subtitle">
            Ajudaremos você a analisar esses dados <br /> com nosso Dashboard
          </p>
          <Link to="/incomes">
            <ButtonIcon text="CONSULTE AGORA" />
          </Link>
        </div>

        <div className="col-6">
          <MainImage className="main-image" />
        </div>
      </div>
    </div>
  );
};

export default Home;
