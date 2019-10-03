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
    _T6 = 3
    _T7 = (_T5 * _T6)
    _T8 = 0
    _T9 = (_T7 < _T8)
    if (_T9 == 0) branch _L10
    _T10 = "Decaf runtime error: The length of the created array should not be less than 0.\n"
    parm _T10
    call _PrintString
    call _Halt
_L10:
    _T11 = 4
    _T12 = (_T11 * _T7)
    _T13 = (_T11 + _T12)
    parm _T13
    _T14 =  call _Alloc
    *(_T14 + 0) = _T7
    _T14 = (_T14 + _T13)
_L11:
    _T13 = (_T13 - _T11)
    if (_T13 == 0) branch _L12
    _T14 = (_T14 - _T11)
    *(_T14 + 0) = _T4
    branch _L11
_L12:
    _T3 = _T14
    _T16 = 1
    _T17 = 10
    _T18 = 0
    _T19 = (_T17 < _T18)
    if (_T19 == 0) branch _L13
    _T20 = "Decaf runtime error: The length of the created array should not be less than 0.\n"
    parm _T20
    call _PrintString
    call _Halt
_L13:
    _T21 = 4
    _T22 = (_T21 * _T17)
    _T23 = (_T21 + _T22)
    parm _T23
    _T24 =  call _Alloc
    *(_T24 + 0) = _T17
    _T24 = (_T24 + _T23)
_L14:
    _T23 = (_T23 - _T21)
    if (_T23 == 0) branch _L15
    _T24 = (_T24 - _T21)
    *(_T24 + 0) = _T16
    branch _L14
_L15:
    _T15 = _T24
    _T26 = "hello"
    _T27 = 3
    _T28 = 0
    _T29 = (_T27 < _T28)
    if (_T29 == 0) branch _L16
    _T30 = "Decaf runtime error: The length of the created array should not be less than 0.\n"
    parm _T30
    call _PrintString
    call _Halt
_L16:
    _T31 = 4
    _T32 = (_T31 * _T27)
    _T33 = (_T31 + _T32)
    parm _T33
    _T34 =  call _Alloc
    *(_T34 + 0) = _T27
    _T34 = (_T34 + _T33)
_L17:
    _T33 = (_T33 - _T31)
    if (_T33 == 0) branch _L18
    _T34 = (_T34 - _T31)
    *(_T34 + 0) = _T26
    branch _L17
_L18:
    _T25 = _T34
    _T36 = 2
    _T37 = 3
    _T38 = (_T36 + _T37)
    _T39 = 0
    _T40 = (_T38 < _T39)
    if (_T40 == 0) branch _L19
    _T41 = "Decaf runtime error: The length of the created array should not be less than 0.\n"
    parm _T41
    call _PrintString
    call _Halt
_L19:
    _T42 = 4
    _T43 = (_T42 * _T38)
    _T44 = (_T42 + _T43)
    parm _T44
    _T45 =  call _Alloc
    *(_T45 + 0) = _T38
    _T45 = (_T45 + _T44)
_L20:
    _T44 = (_T44 - _T42)
    if (_T44 == 0) branch _L21
    _T45 = (_T45 - _T42)
    *(_T45 + 0) = _T3
    branch _L20
_L21:
    _T35 = _T45
    _T47 = 10
    _T48 = 0
    _T49 = (_T47 < _T48)
    if (_T49 == 0) branch _L22
    _T50 = "Decaf runtime error: The length of the created array should not be less than 0.\n"
    parm _T50
    call _PrintString
    call _Halt
_L22:
    _T51 = 4
    _T52 = (_T51 * _T47)
    _T53 = (_T51 + _T52)
    parm _T53
    _T54 =  call _Alloc
    *(_T54 + 0) = _T47
    _T54 = (_T54 + _T53)
_L23:
    _T53 = (_T53 - _T51)
    if (_T53 == 0) branch _L24
    _T54 = (_T54 - _T51)
    *(_T54 + 0) = _T25
    branch _L23
_L24:
    _T46 = _T54
}

