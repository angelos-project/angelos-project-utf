import collections
import csv
import unicodedata


BlockData = collections.namedtuple('BlockData', 'name range klass')
BlockDataColl = collections.namedtuple('BlockDataColl', 'data name klass')

def parse_blk() -> BlockDataColl:
    data = set()
    names = dict()
    klass = dict()
    with open('src/commonMain/resources/Blocks.txt') as blk_file:
        for row in blk_file.readlines(False):
            if row.startswith('#'):
                continue
            if row.find(';') != -1:
                r, n = row.split(';')
                b, e = r.split("..")
                bd = BlockData(
                    name=n.strip(),
                    range=(int(b, 16), int(e, 16)),
                    klass=classify(n.strip())
                )
                data.add(bd)
                names[bd.name] = bd
                klass[bd.klass] = bd

    return BlockDataColl(
        data=frozenset(data),
        name=names,
        klass=klass
    )


def classify(name):
    return name.title().replace(' ', '').replace('-', '')