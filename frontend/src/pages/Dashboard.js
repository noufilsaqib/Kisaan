import Layout from "../components/Layout";
import Sidebar from "../components/Sidebar";
import styles from "../styles/Dashboard.module.css";

export default function Dashboard() {
  return (
    <Layout title="Dashboard">
      <div className={styles.container}>
        <Sidebar active="analytics" />
        <div className={styles.content}>
          <h2>Dashboard</h2>
        </div>
      </div>
    </Layout>
  );
}
