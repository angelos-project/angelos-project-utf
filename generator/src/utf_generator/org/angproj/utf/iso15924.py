import collections

LangCode = collections.namedtuple('LangCode', 'code num en fr enum klass')
LangCodeColl = collections.namedtuple('LangCodeColl', 'data code num enum klass')


def classify_enum(name):
    return name.replace('_', ' ').replace('-', ' ').upper().replace(' ', '_')

def classify_klass(name):
    return name.replace('_', ' ').replace('-', ' ').title().replace(' ', '')

def parse_doc() -> LangCodeColl:
    data = set()
    code = dict()
    num = dict()
    enum = dict()
    klass = dict()

    with open("src/commonMain/resources/iso15924.txt", "r") as iso_file:
        while not iso_file.readline().startswith("# Format:"):
            pass

        headers = iso_file.readline()[1:].strip().split(';')

        for line in iso_file.readlines():
            row = line.strip().split(';')
            if len(row) != len(headers):
                continue

            lc = LangCode(
                code=row[0].strip(),
                num=int(row[1]),
                en=row[2],
                fr=row[3],
                enum=classify_enum(row[4]),
                klass=classify_klass(row[4])
                #rename=True
            )
            data.add(lc)

    data = frozenset(data)

    for lc in data:
        code[lc.code] = lc
        num[lc.num] = lc
        enum[lc.enum] = lc
        klass[lc.klass] = lc

    return LangCodeColl(
        data = data,
        code = code,
        num = num,
        enum = enum,
        klass = klass,
    )


