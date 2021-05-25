import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import DataTable from './core/components/DataTable';
import Navbar from './core/components/Navbar';
import Home from './pages/Home';

const Routes = () => (
    <BrowserRouter>
        <Navbar />
        <Switch>
            <Route path="/" exact>
                <Home />
            </Route>
            <Route path="/incomes">
                <DataTable/>
            </Route>
        </Switch>
    </BrowserRouter>
);

export default Routes;
