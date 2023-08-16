import './App.css';
import { Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import HomePage from './pages/HomePage';
// import AboutUsPage
import BaoziPage from './pages/BaoziPage';
import SidesPage from './pages/SidesPage';
import DessertsPage from './pages/DessertsPage';
import DrinksPage from './pages/DrinksPage';

function App() {
  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path='/' element={<HomePage />} />
        {/* <Route path='/about-us' element={< />} /> */}
        <Route path='/baozi' element={<BaoziPage />} />
        <Route path='/sides' element={<SidesPage />} />
        <Route path='/desserts' element={<DessertsPage />} />
        <Route path='/drinks' element={<DrinksPage />} />
      </Routes>
      {/* <Footer /> */}
    </div>
  );
}
export default App;
