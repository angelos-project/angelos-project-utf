import collections
from lxml import etree
from io import StringIO, BytesIO

LangScript = collections.namedtuple('LangScript', 'lang scripts')
LangScriptColl = collections.namedtuple('LangScriptColl', 'lang')


def parse_lang() -> LangScriptColl:
    utf8_parser = etree.XMLParser(encoding='utf-8')
    data = set()
    lang = dict()
    with open("src/commonMain/resources/supplementalData.xml", "r") as xml_file:
        tree = etree.fromstring(xml_file.read().encode('utf-8'), parser=utf8_parser)
        for el in tree.xpath('/supplementalData/languageData/language'):
            if 'scripts' in el.attrib.keys():
                if el.attrib["type"] not in lang.keys():
                    lang[el.attrib["type"]] = list()
                for script in el.attrib['scripts'].split(' '):
                    lang[el.attrib["type"]].append(script)
    return LangScriptColl(lang=lang)
