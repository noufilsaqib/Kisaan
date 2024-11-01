import { useDispatch } from "react-redux";
import {
  Camera,
  ChartColumnIncreasing,
  LogOut,
  UserRoundCog,
} from "lucide-react";
import { clearSession } from "../redux/actions/UserAction";
import styles from "../styles/Sidebar.module.css";

export default function Sidebar({ active = "analytics" }) {
  const dispatch = useDispatch();

  return (
    <div className={styles.sidebar}>
      <h1>Kisaan</h1>

      <div className={styles.navlinks}>
        <div
          className={`${styles.navlink} ${
            active === "analytics" && styles.active
          }`}
        >
          <ChartColumnIncreasing size={32} />
          <p>Analytics</p>
        </div>

        <div
          className={`${styles.navlink} ${
            active === "camera" && styles.active
          }`}
        >
          <Camera size={32} />
          <p>Camera</p>
        </div>

        <div
          className={`${styles.navlink} ${
            active === "profile" && styles.active
          }`}
        >
          <UserRoundCog size={32} />
          <p>Profile</p>
        </div>

        <div
          className={styles.navlink}
          onClick={() => dispatch(clearSession())}
        >
          <LogOut size={32} />
          <p>Logout</p>
        </div>
      </div>
    </div>
  );
}
