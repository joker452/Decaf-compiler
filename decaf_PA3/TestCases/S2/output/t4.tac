VTABLE(_Main) {
    <empty>
    Main
    _Main.tester;
    _Main.start;
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T3 = 12
    parm _T3
    _T4 =  call _Alloc
    _T5 = 0
    *(_T4 + 4) = _T5
    *(_T4 + 8) = _T5
    _T6 = VTBL <_Main>
    *(_T4 + 0) = _T6
    return _T4
}

FUNCTION(_Main.tester) {
memo '_T0:4 _T1:8'
_Main.tester:
    _T7 = *(_T0 + 8)
    _T8 = 1
    _T9 = 0
    _T10 = (_T8 < _T9)
    if (_T10 == 0) branch _L12
    _T11 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T11
    call _PrintString
    call _Halt
_L12:
    _T12 = 4
    _T13 = (_T12 * _T8)
    _T14 = (_T12 + _T13)
    parm _T14
    _T15 =  call _Alloc
    *(_T15 + 0) = _T8
    _T16 = 0
    _T15 = (_T15 + _T14)
_L13:
    _T14 = (_T14 - _T12)
    if (_T14 == 0) branch _L14
    _T15 = (_T15 - _T12)
    *(_T15 + 0) = _T16
    branch _L13
_L14:
    *(_T0 + 8) = _T15
    _T17 = 0
    _T18 = (_T1 < _T17)
    if (_T18 == 0) branch _L15
    _T19 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T19
    call _PrintString
    call _Halt
_L15:
    _T20 = 4
    _T21 = (_T20 * _T1)
    _T22 = (_T20 + _T21)
    parm _T22
    _T23 =  call _Alloc
    *(_T23 + 0) = _T1
    _T24 = 0
    _T23 = (_T23 + _T22)
_L16:
    _T22 = (_T22 - _T20)
    if (_T22 == 0) branch _L17
    _T23 = (_T23 - _T20)
    *(_T23 + 0) = _T24
    branch _L16
_L17:
    return _T23
}

FUNCTION(_Main.start) {
memo '_T2:4'
_Main.start:
    _T28 = 1
    _T25 = _T28
_L18:
    _T29 = 5
    _T30 = (_T25 < _T29)
    if (_T30 == 0) branch _L19
    _T32 = 2
    _T33 = 0
    _T34 = (_T32 == _T33)
    if (_T34 == 0) branch _L20
    _T35 = "Decaf runtime error: Division by zero error.\n"
    parm _T35
    call _PrintString
    call _Halt
_L20:
    _T36 = (_T25 % _T32)
    _T37 = 0
    _T38 = (_T36 == _T37)
    if (_T38 == 0) branch _L21
    parm _T2
    parm _T25
    _T39 = *(_T2 + 0)
    _T40 = *(_T39 + 8)
    _T41 =  call _T40
    _T27 = _T41
    branch _L19
_L21:
    _T42 = "Loop "
    parm _T42
    call _PrintString
    parm _T25
    call _PrintInt
    _T43 = "\n"
    parm _T43
    call _PrintString
    _T44 = 1
    _T45 = (_T25 + _T44)
    _T25 = _T45
    branch _L18
_L19:
    _T46 = 0
    _T47 = *(_T27 - 4)
    _T48 = (_T46 < _T47)
    if (_T48 == 0) branch _L22
    _T49 = 0
    _T50 = (_T46 < _T49)
    if (_T50 == 0) branch _L23
_L22:
    _T51 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T51
    call _PrintString
    call _Halt
_L23:
    _T52 = 4
    _T53 = (_T46 * _T52)
    _T54 = (_T27 + _T53)
    _T55 = *(_T54 + 0)
    _T56 = 0
    _T57 = 4
    _T58 = (_T46 * _T57)
    _T59 = (_T27 + _T58)
    *(_T59 + 0) = _T56
    _T60 = 0
    _T61 = *(_T27 - 4)
    _T62 = (_T60 < _T61)
    if (_T62 == 0) branch _L24
    _T63 = 0
    _T64 = (_T60 < _T63)
    if (_T64 == 0) branch _L25
_L24:
    _T65 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T65
    call _PrintString
    call _Halt
_L25:
    _T66 = 4
    _T67 = (_T60 * _T66)
    _T68 = (_T27 + _T67)
    _T69 = *(_T68 + 0)
    _T70 = *(_T27 - 4)
    _T71 = (_T69 < _T70)
    if (_T71 == 0) branch _L26
    _T72 = 0
    _T73 = (_T69 < _T72)
    if (_T73 == 0) branch _L27
_L26:
    _T74 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T74
    call _PrintString
    call _Halt
_L27:
    _T75 = 4
    _T76 = (_T69 * _T75)
    _T77 = (_T27 + _T76)
    _T78 = *(_T77 + 0)
    parm _T78
    call _PrintInt
    _T79 = "\n"
    parm _T79
    call _PrintString
    _T80 = *(_T27 - 4)
    parm _T80
    call _PrintInt
    _T81 = "\n"
    parm _T81
    call _PrintString
}

FUNCTION(main) {
memo ''
main:
    _T82 =  call _Main_New
    parm _T82
    _T83 = *(_T82 + 0)
    _T84 = *(_T83 + 12)
    call _T84
}

