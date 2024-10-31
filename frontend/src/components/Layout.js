import { Helmet } from "react-helmet";
import Navbar from "./Navbar";
// import Footer from "./Footer";

export default function Layout({ title, isLandingPage = false, children }) {
  if (title && typeof document !== "undefined") {
    document.title = isLandingPage ? "Kisaan" : `${title} | Kisaan`;
  }

  return (
    <>
      <Helmet>
        <meta charSet="utf-8" />
        <title>
          {isLandingPage ? "Kisaan" : `${title} | Kisaan`}
        </title>
      </Helmet>
      <Navbar />
      <div id="wrapper">{children}</div>
    </>
  );
}
