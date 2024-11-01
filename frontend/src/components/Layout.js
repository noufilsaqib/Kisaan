import { Helmet } from "react-helmet";

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
      {children}
    </>
  );
}
