import collections
import csv
import unicodedata


ScriptData = collections.namedtuple('ScriptData', 'name points klass')
ScriptDataColl = collections.namedtuple('ScriptDataColl', 'data name klass')

def parse_scr():
    data = set()
    names = dict()
    klass = dict()

    scr = dict()
    cp = dict()
    with open('src/commonMain/resources/Scripts.txt') as scr_file:
        for row in scr_file.readlines(False):
            if row.startswith('#'):
                continue
            if row.find(';') != -1:
                t, t1 = row.split(';')
                name = t1.split('#')[0].strip()
                kls =  t1.split('#')[0].strip().replace('_', '')
                s = kls
                if not s in scr.keys():
                    cp[s] = name
                    scr[s] = set()
                if t.find("..") == -1:
                    scr[s].add(int(t, 16))
                else:
                    b, e = t.split("..")
                    for i in range(int(b, 16), int(e, 16) + 1):
                        scr[s].add(i)

        for key in scr.keys():
            kls = ScriptData(name=cp[key], points=frozenset(scr[key]), klass=key)
            data.add(kls)
            names[kls.name] = kls
            klass[kls.klass] = kls

    return ScriptDataColl(
        data=frozenset(data),
        name=names,
        klass=klass
    )