import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Navbar from './core/components/Navbar';
import Home from './pages/Home';
import IncomeList from './pages/IncomeList';

const Routes = () => (
    <BrowserRouter>
        <Navbar />
        <Switch>
            <Route path="/" exact>
                <Home />
            </Route>
            <Route path="/incomes">
                <IncomeList/>
            </Route>
        </Switch>
    </BrowserRouter>
);

export default Routes;
