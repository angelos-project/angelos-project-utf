from .iso639 import parse_iso
from .iso15924 import parse_doc
from .supplementalData_language import parse_lang
from .script import parse_scr
from .block import parse_blk
from .blk_generate import blk_generate
from .scr_generate import scr_generate
from .lng_generate import lng_generate

def main():
    blk_generate()
    scr_generate()
    lng_generate()

def utf_generate():
    main()