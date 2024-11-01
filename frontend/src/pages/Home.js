import Layout from "../components/Layout";
import Navbar from "../components/Navbar";

export default function Home() {
  return (
    <Layout isLandingPage>
      <Navbar />
      <div id="wrapper">
        <h1>Home</h1>
      </div>
    </Layout>
  );
}
