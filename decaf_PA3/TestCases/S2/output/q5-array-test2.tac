VTABLE(_Main) {
    <empty>
    Main
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T0 = 4
    parm _T0
    _T1 =  call _Alloc
    _T2 = VTBL <_Main>
    *(_T1 + 0) = _T2
    return _T1
}

FUNCTION(main) {
memo ''
main:
    _T4 = 3
    _T5 = 2
    _T6 = 0
    _T7 = (_T5 < _T6)
    if (_T7 == 0) branch _L10
    _T8 = "Decaf runtime error: The length of the created array should not be less than 0.\n"
    parm _T8
    call _PrintString
    call _Halt
_L10:
    _T9 = 4
    _T10 = (_T9 * _T5)
    _T11 = (_T9 + _T10)
    parm _T11
    _T12 =  call _Alloc
    *(_T12 + 0) = _T5
    _T12 = (_T12 + _T11)
_L11:
    _T11 = (_T11 - _T9)
    if (_T11 == 0) branch _L12
    _T12 = (_T12 - _T9)
    *(_T12 + 0) = _T4
    branch _L11
_L12:
    _T3 = _T12
    _T14 = 3
    _T15 = *(_T3 - 4)
    _T16 = (_T14 < _T15)
    if (_T16 == 0) branch _L13
    _T17 = 0
    _T18 = (_T14 < _T17)
    if (_T18 == 0) branch _L14
_L13:
    _T19 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T19
    call _PrintString
    call _Halt
_L14:
    _T20 = 4
    _T21 = (_T14 * _T20)
    _T22 = (_T3 + _T21)
    _T23 = *(_T22 + 0)
    _T13 = _T23
    _T25 = *(_T3 - 4)
    _T26 = (_T13 < _T25)
    if (_T26 == 0) branch _L15
    _T27 = 0
    _T28 = (_T13 < _T27)
    if (_T28 == 0) branch _L16
_L15:
    _T29 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T29
    call _PrintString
    call _Halt
_L16:
    _T30 = 4
    _T31 = (_T13 * _T30)
    _T32 = (_T3 + _T31)
    _T33 = *(_T32 + 0)
    _T24 = _T33
    _T35 = 2
    _T36 = 2
    _T38 = *(_T3 - 4)
    _T39 = (_T35 < _T38)
    if (_T39 == 0) branch _L17
    _T40 = 0
    _T41 = (_T35 < _T40)
    if (_T41 == 0) branch _L18
_L17:
    _T37 = _T36
    branch _L19
_L18:
    _T42 = 4
    _T43 = (_T35 * _T42)
    _T44 = (_T3 + _T43)
    _T37 = *(_T44 + 0)
_L19:
    _T45 = 3
    _T46 = (_T37 + _T45)
    _T34 = _T46
}

