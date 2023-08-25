import './App.css';
import { Route, Routes } from 'react-router-dom';
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle"
import Header from './components/Header';
import HomePage from './pages/HomePage';
import EventsPage from './pages/EventsPage';
import BaoziPage from './pages/BaoziPage';
import SidesPage from './pages/SidesPage';
import DessertsPage from './pages/DessertsPage';
import DrinksPage from './pages/DrinksPage';
import Footer from './components/Footer';

function App() {
  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path='/' element={<HomePage />} />
        <Route path='/events' element={<EventsPage />} />
        <Route path='/baozi' element={<BaoziPage />} />
        <Route path='/sides' element={<SidesPage />} />
        <Route path='/desserts' element={<DessertsPage />} />
        <Route path='/drinks' element={<DrinksPage />} />
      </Routes>
      <Footer />
    </div>
  );
}
export default App;
