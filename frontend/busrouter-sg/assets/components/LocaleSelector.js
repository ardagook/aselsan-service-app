import { h } from 'preact';
import { useTranslation } from 'react-i18next';

export default function LocaleSelector() {
  const { t, i18n } = useTranslation();
  return (
    <label id="locale-selector">
      🌐{' '}
      <select
        onchange={(e) => {
          const lang = e.target.value;
          i18n.changeLanguage(lang);
        }}
        defaultValue={i18n.resolvedLanguage}
        
      >
        <option value="tr" lang='tr'>Türkçe</option>
        <option value="en"lang='en'>English</option>
   
      </select>{' '}
   
    </label>
  );
}
