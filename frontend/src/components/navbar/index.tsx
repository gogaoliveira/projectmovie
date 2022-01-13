/* eslint-disable jsx-a11y/anchor-is-valid */
import { ReactComponent as GithubIcon } from 'assets/img/github.svg';
import './styles.css';

function Navbar() {
    return (
        <header>
            <nav className="container">
                <div className="movie-nav-content">
                    <h1>ProjectMovie</h1>
                    <a href="#" target="_blank" rel="noreferrer">
                        <div className="movie-contact-container">
                            <GithubIcon />
                            <p className='movie-contact-link'>/gogaoliveira</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    )
}

export default Navbar;