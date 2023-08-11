import './App.css';
import { Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';
import HomePage from './pages/HomePage';
import BaoziPage from './pages/BaoziPage';
import SidesPage from './pages/SidesPage';
import DessertsPage from './pages/DessertsPage';
import DrinksPage from './pages/DrinksPage';

function App() {
  return (
    <div className="App">
      <Navbar />
      <Routes>
        <Route path='/' element={<HomePage />} />
        < Route path='/baozi' element={<BaoziPage />} />
        < Route path='/sides' element={<SidesPage />} />
        < Route path='/desserts' element={<DessertsPage />} />
        < Route path='/drinks' element={<DrinksPage />} />
      </Routes>
      {/* <Footer /> */}
    </div>
  );
}
export default App;
