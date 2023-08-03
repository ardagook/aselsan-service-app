import { h } from 'preact';
import { useEffect, useState } from 'preact/hooks';
import { useTranslation, Trans } from 'react-i18next';

import LocaleSelector from './LocaleSelector';

export default function About() {
  const { t, i18n } = useTranslation();
  const [hidden, setHidden] = useState(true);
  useEffect(() => {
    try {
      const intro = localStorage.getItem('busroutersg.about');
      if (intro !== 'true') setHidden(false);
    } catch (e) {}

    const $logo = document.getElementById('logo');
    if ($logo) {
      $logo.onclick = (e) => {
        e.preventDefault();
        setHidden(!hidden);
      };
    }
  }, []);

  return (
    <div id="about" hidden={hidden} onClick={() => setHidden(true)}>
      <section onClick={(e) => e.stopPropagation()}>
        <h2>
          {t('app.name')}
          <br />
          <small>{t('app.shortDescription')}</small>
        </h2>
        <p>{t('app.description')}</p>
        <LocaleSelector />
        <hr />
     

       
        <div class="popover-buttons">
          <button
            class="popover-button"
            onClick={() => {
              setHidden(true);
              try {
                localStorage.setItem('busroutersg.about', 'true');
              } catch (e) {}
            }}
          >
            {t('about.explore')}
          </button>
        </div>
      </section>
    </div>
  );
}
