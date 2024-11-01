import { Link, NavLink } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { clearSession } from "../redux/actions/UserAction";
import styles from "../styles/Navbar.module.css";

export default function Navbar() {
  const dispatch = useDispatch();

  const isLoggedIn = useSelector((state) => state.user.isLoggedIn);

  return (
    <nav className={styles.navbar}>
      <Link to="/" className={styles.logo}>
        <span>Kisaan</span>
      </Link>
      {isLoggedIn ? (
        <>
          <NavLink className={styles.navLink} to="/dashboard">
            Dashboard
          </NavLink>
          <Link
            className={styles.navLink}
            onClick={async () => dispatch(clearSession())}
          >
            Logout
          </Link>
        </>
      ) : (
        // @TODO: Create login auth
        <NavLink className={styles.navLink} to="/dashboard">
          Login
        </NavLink>
      )}
    </nav>
  );
}
