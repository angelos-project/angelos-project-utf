import collections
import csv
import unicodedata

LangName = collections.namedtuple('LangName', 'short long klass name enum')
LangNameColl = collections.namedtuple('LangNameColl', 'data short long')

def parse_iso():
    data = set()
    short = dict()
    long = dict()
    with open('src/commonMain/resources/iso-639-3.tab.txt') as csvfile:
        reader = csv.DictReader(csvfile, delimiter='\t')
        for row in reader:
            ln = LangName(
                short=row['Part1'],
                long=row['Id'],
                klass=classify(row['Ref_Name']),
                name=row['Ref_Name'],
                enum=classify_enum(row['Ref_Name'])
            )
            data.add(ln)
            short[ln.short] = ln
            long[ln.long] = ln

    return LangNameColl(
        data=frozenset(data),
        short=short,
        long=long
    )


def classify(name):
    name =  name.replace('_', ' ').replace('-', ' ').title().replace(' ', '').replace('(', '').replace(')', '').strip()
    name = ''.join(c for c in unicodedata.normalize('NFD', name)
                  if unicodedata.category(c) != 'Mn')
    return name.replace("'", '').replace('.', '').replace('ʼ', '').replace('ɛ', 'e')

def classify_enum(name):
    name =  name.replace('-', '_').replace(' ', '_').upper().replace('(', '').replace(')', '').strip()
    name = ''.join(c for c in unicodedata.normalize('NFD', name)
                  if unicodedata.category(c) != 'Mn')
    return name.replace("'", '').replace('.', '').replace('ʼ', '').replace('Ɛ', 'E')
