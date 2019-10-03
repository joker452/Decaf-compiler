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
    _T5 = 6
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
    _T13 = 1
    _T14 = *(_T3 - 4)
    _T15 = (_T13 < _T14)
    if (_T15 == 0) branch _L13
    _T16 = 0
    _T17 = (_T13 < _T16)
    if (_T17 == 0) branch _L14
_L13:
    _T18 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T18
    call _PrintString
    call _Halt
_L14:
    _T19 = 4
    _T20 = (_T13 * _T19)
    _T21 = (_T3 + _T20)
    _T22 = *(_T21 + 0)
    _T23 = 1
    _T24 = *(_T3 - 4)
    _T25 = (_T23 < _T24)
    if (_T25 == 0) branch _L15
    _T26 = 0
    _T27 = (_T23 < _T26)
    if (_T27 == 0) branch _L16
_L15:
    _T28 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T28
    call _PrintString
    call _Halt
_L16:
    _T29 = 4
    _T30 = (_T23 * _T29)
    _T31 = (_T3 + _T30)
    _T32 = *(_T31 + 0)
    _T33 = 1
    _T34 = (_T32 + _T33)
    _T35 = 4
    _T36 = (_T13 * _T35)
    _T37 = (_T3 + _T36)
    *(_T37 + 0) = _T34
    _T38 = 0
    _T39 = *(_T3 - 4)
    _T40 = (_T38 < _T39)
    if (_T40 == 0) branch _L17
    _T41 = 0
    _T42 = (_T38 < _T41)
    if (_T42 == 0) branch _L18
_L17:
    _T43 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T43
    call _PrintString
    call _Halt
_L18:
    _T44 = 4
    _T45 = (_T38 * _T44)
    _T46 = (_T3 + _T45)
    _T47 = *(_T46 + 0)
    parm _T47
    call _PrintInt
    _T48 = "\n"
    parm _T48
    call _PrintString
    _T49 = 1
    _T50 = *(_T3 - 4)
    _T51 = (_T49 < _T50)
    if (_T51 == 0) branch _L19
    _T52 = 0
    _T53 = (_T49 < _T52)
    if (_T53 == 0) branch _L20
_L19:
    _T54 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T54
    call _PrintString
    call _Halt
_L20:
    _T55 = 4
    _T56 = (_T49 * _T55)
    _T57 = (_T3 + _T56)
    _T58 = *(_T57 + 0)
    parm _T58
    call _PrintInt
    _T59 = "\n"
    parm _T59
    call _PrintString
}

