import './App.css';
import { Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import HomePage from './pages/HomePage';
import AboutUsPage from './pages/AboutUsPage';
import BaoziPage from './pages/BaoziPage';
import SidesPage from './pages/SidesPage';
import DessertsPage from './pages/DessertsPage';
import DrinksPage from './pages/DrinksPage';
import Footer from './components/Footer';
import FAQsPage from './pages/FAQsPage';

function App() {
  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path='/' element={<HomePage />} />
        <Route path='/about-us' element={<AboutUsPage />} />
        <Route path='/baozi' element={<BaoziPage />} />
        <Route path='/sides' element={<SidesPage />} />
        <Route path='/desserts' element={<DessertsPage />} />
        <Route path='/drinks' element={<DrinksPage />} />
        <Route path='/FAQs' element={<FAQsPage />} />
      </Routes>
      <Footer />
    </div>
  );
}
export default App;
