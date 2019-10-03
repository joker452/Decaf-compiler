VTABLE(_MultipleFormals) {
    <empty>
    MultipleFormals
    _MultipleFormals.foo;
    _MultipleFormals.method;
}

VTABLE(_Main) {
    <empty>
    Main
}

FUNCTION(_MultipleFormals_New) {
memo ''
_MultipleFormals_New:
    _T5 = 4
    parm _T5
    _T6 =  call _Alloc
    _T7 = VTBL <_MultipleFormals>
    *(_T6 + 0) = _T7
    return _T6
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T8 = 4
    parm _T8
    _T9 =  call _Alloc
    _T10 = VTBL <_Main>
    *(_T9 + 0) = _T10
    return _T9
}

FUNCTION(_MultipleFormals.foo) {
memo '_T0:4 _T1:8 _T2:12 _T3:16'
_MultipleFormals.foo:
    _T11 = (_T1 + _T2)
    _T12 = (_T11 + _T3)
    _T13 = 3
    _T14 = 0
    _T15 = (_T13 == _T14)
    if (_T15 == 0) branch _L13
    _T16 = "Decaf runtime error: Division by zero error.\n"
    parm _T16
    call _PrintString
    call _Halt
_L13:
    _T17 = (_T12 / _T13)
    return _T17
}

FUNCTION(_MultipleFormals.method) {
memo '_T4:4'
_MultipleFormals.method:
    _T21 = 3
    _T18 = _T21
    _T22 = (_T18 * _T18)
    _T23 = (_T18 + _T22)
    _T19 = _T23
    _T24 = 0
    _T25 = (_T18 == _T24)
    if (_T25 == 0) branch _L14
    _T26 = "Decaf runtime error: Division by zero error.\n"
    parm _T26
    call _PrintString
    call _Halt
_L14:
    _T27 = (_T19 / _T18)
    _T28 = (_T18 - _T27)
    _T29 = 0
    _T30 = (_T19 == _T29)
    if (_T30 == 0) branch _L15
    _T31 = "Decaf runtime error: Division by zero error.\n"
    parm _T31
    call _PrintString
    call _Halt
_L15:
    _T32 = (_T28 % _T19)
    _T20 = _T32
    parm _T4
    parm _T18
    parm _T19
    parm _T20
    _T33 = *(_T4 + 0)
    _T34 = *(_T33 + 8)
    _T35 =  call _T34
    return _T35
}

FUNCTION(main) {
memo ''
main:
}

